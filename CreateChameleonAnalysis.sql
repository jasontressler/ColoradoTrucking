drop table if exists ChameleonAnalysis;
create table ChameleonAnalysis (
	PairID int identity,
	Flag int,
	DayDiff int,
	inDot int,
	inName varchar(100),
	inStreet varchar(100),
	inCity varchar(100),
	inState varchar(100),
	inZip varchar(100),
	inPhone varchar(20),
	inEmail varchar(100),
	inLat decimal(9,6),
	inLon decimal(9,6),
	inDate varchar(100),
	outDot int,
	outName varchar(100),
	outDate date,
	outReason varchar(100),
	outStatus varchar(100),
	constraint pk_inOutName Primary key (PairID, inName),
	index ndx_City (inCity),
	index ndx_Zip (inZip))

insert into ChameleonAnalysis(Flag, DayDiff, inDot, inName, inStreet, inCity, inState, inZip, inPhone, inEmail, inLat, inLon, inDate, outDot, outName, outDate, outReason, outStatus)
select	
	(case --Give rating flag based on time between OOS close date and IS open date; only rate where OOS is inactive
		when [DayDiff] <= 30	and [x].[outStatus] != 'active' then 5	--1 month
		when [DayDiff] <= 90	and [x].[outStatus] != 'active' then 4 --3 months
		when [DayDiff] <= 180	and [x].[outStatus] != 'active' then 3 --6 months
		when [DayDiff] <= 270	and [x].[outStatus] != 'active' then 2 --9 months
		when [DayDiff] < 365	and [x].[outStatus] != 'active' then 1 --1 year
			else 0
		end) as 'Flag', [x].* 
from (
	select
		ABS(DATEDIFF(day, [InService].[ADD_DATE], [OOS].[oos_date])) as 'DayDiff',
	--In Service Companies
		[InService].[DOT_NUMBER]			as 'inDOT',
		trim([InService].[LEGAL_NAME])		as 'inName',
		trim([InService].[PHY_STREET])		as 'inStreet',
		trim([InService].[PHY_CITY]	)		as 'inCity',
		trim([InService].[PHY_STATE])		as 'inState',
		trim([InService].[PHY_ZIP]	)		as 'inZip',
		trim([InService].[TELEPHONE])		as 'inPhone',
		trim([InService].[EMAIL_ADDRESS])	as 'inEmail',
		[InService].[GPSLatitude]			as 'inLat',
		[InService].[GPSLongitude]			as 'inLon',
		trim([InService].[ADD_DATE])		as 'inDate',
	--Out of Service Companies
		[OOS].[USDOT#]						as 'outDOT',
		trim([OOS].[legal_name])			as 'outName',
		[OOS].[oos_date]					as 'outDate',
		trim([OOS].[oos_reason])			as 'outReason',
		trim([OOS].[status])				as 'outStatus'
	from InService
		left outer join OOS 
			--Join where same location
			on [InService].[GPSLatitude] = [OOS].[GPSLatitude]
			and [InService].[GPSLongitude] = [OOS].[GPSLongitude]
	where [InService].[PHY_STATE] = 'CO'
	) x


--where [oos_date] is null
--		or [oos_date] in (
--			select InService.Legal_name, max(oos_date) from InService
--			left outer join OOS 
--				--Join where same location
--				on [InService].[GPSLatitude] = [OOS].[GPSLatitude]
--				and [InService].[GPSLongitude] = [OOS].[GPSLongitude]
--			group by [InService].[legal_name])
