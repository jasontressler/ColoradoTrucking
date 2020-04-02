select * into ChameleonAnalysis from
(select	
	(case --Give rating flag based on time between OOS close date and IS open date; only rate where OOS is inactive
		when [MonthDiff] <= 1	and [x].[outStatus] != 'active' then 5	--1 month
		when [MonthDiff] <= 3	and [x].[outStatus] != 'active' then 4 --3 months
		when [MonthDiff] <= 6	and [x].[outStatus] != 'active' then 3 --6 months
		when [MonthDiff] <= 9	and [x].[outStatus] != 'active' then 2 --9 months
		when [MonthDiff] < 12	and [x].[outStatus] != 'active' then 1 --1 year
			else 0
		end) as 'Flag', [x].* 
from (
	select
		ABS(DATEDIFF(month, [InService].[ADD_DATE], [OOS].[oos_date])) as 'MonthDiff',
	--In Service Companies
		[InService].[DOT_NUMBER]	as 'inDOT',
		[InService].[LEGAL_NAME]	as 'inName',
		[InService].[PHY_STREET]	as 'inStreet',
		[InService].[PHY_CITY]		as 'inCity',
		[InService].[PHY_ZIP]		as 'inZip',
		[InService].[TELEPHONE]		as 'inPhone',
		[InService].[EMAIL_ADDRESS] as 'inEmail',
		[InService].[GPSLatitude]	as 'inLat',
		[InService].[GPSLongitude]	as 'inLon',
		[InService].[ADD_DATE]		as 'inDate',
	--Out of Service Companies
		[OOS].[USDOT#]				as 'outDOT',
		[OOS].[legal_name]			as 'outName',
		[OOS].[oos_date]			as 'outDate',
		[OOS].[oos_reason]			as 'outReason',
		[OOS].[status]				as 'outStatus'
	from InService
		left outer join OOS 
			--Join where same location
			on [InService].[GPSLatitude] = [OOS].[GPSLatitude]
			and [InService].[GPSLongitude] = [OOS].[GPSLongitude]
) x ) y