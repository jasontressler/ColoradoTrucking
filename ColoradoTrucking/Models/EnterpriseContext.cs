using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace ColoradoTrucking.Models
{
    public partial class EnterpriseContext : DbContext
    {
        public EnterpriseContext()
        {
        }

        public EnterpriseContext(DbContextOptions<EnterpriseContext> options)
            : base(options)
        {
        }

        public virtual DbSet<InService> InService { get; set; }
        public virtual DbSet<Oos> Oos { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {
            if (!optionsBuilder.IsConfigured) {
                optionsBuilder.UseSqlServer("Data Source=jason-school.database.windows.net;Initial Catalog=Enterprise;User ID=jwt11;Password=JwT#364075;Connect Timeout=30;Encrypt=True;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
            }
        }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<InService>(entity =>
            {
                entity.HasKey(e => e.DotNumber)
                    .HasName("PK_DOT");

                entity.Property(e => e.DotNumber)
                    .HasColumnName("DOT_NUMBER")
                    .ValueGeneratedNever();

                entity.Property(e => e.AddDate)
                    .IsRequired()
                    .HasColumnName("ADD_DATE")
                    .IsUnicode(false);

                entity.Property(e => e.CarrierOperation)
                    .IsRequired()
                    .HasColumnName("CARRIER_OPERATION")
                    .IsUnicode(false);

                entity.Property(e => e.DbaName)
                    .HasColumnName("DBA_NAME")
                    .IsUnicode(false);

                entity.Property(e => e.DriverTotal).HasColumnName("DRIVER_TOTAL");

                entity.Property(e => e.EmailAddress)
                    .HasColumnName("EMAIL_ADDRESS")
                    .IsUnicode(false);

                entity.Property(e => e.Fax)
                    .HasColumnName("FAX")
                    .IsUnicode(false);

                entity.Property(e => e.Gpslatitude)
                    .HasColumnName("GPSLatitude")
                    .HasColumnType("decimal(9, 6)");

                entity.Property(e => e.Gpslongitude)
                    .HasColumnName("GPSLongitude")
                    .HasColumnType("decimal(9, 6)");

                entity.Property(e => e.HmFlag)
                    .IsRequired()
                    .HasColumnName("HM_FLAG")
                    .IsUnicode(false);

                entity.Property(e => e.LegalName)
                    .IsRequired()
                    .HasColumnName("LEGAL_NAME")
                    .IsUnicode(false);

                entity.Property(e => e.MailingCity)
                    .HasColumnName("MAILING_CITY")
                    .IsUnicode(false);

                entity.Property(e => e.MailingCountry)
                    .HasColumnName("MAILING_COUNTRY")
                    .IsUnicode(false);

                entity.Property(e => e.MailingState)
                    .HasColumnName("MAILING_STATE")
                    .IsUnicode(false);

                entity.Property(e => e.MailingStreet)
                    .HasColumnName("MAILING_STREET")
                    .IsUnicode(false);

                entity.Property(e => e.MailingZip)
                    .HasColumnName("MAILING_ZIP")
                    .IsUnicode(false);

                entity.Property(e => e.Mcs150Date)
                    .HasColumnName("MCS150_DATE")
                    .IsUnicode(false);

                entity.Property(e => e.Mcs150Mileage).HasColumnName("MCS150_MILEAGE");

                entity.Property(e => e.Mcs150MileageYear).HasColumnName("MCS150_MILEAGE_YEAR");

                entity.Property(e => e.NbrPowerUnit).HasColumnName("NBR_POWER_UNIT");

                entity.Property(e => e.OicState)
                    .IsRequired()
                    .HasColumnName("OIC_STATE")
                    .IsUnicode(false);

                entity.Property(e => e.PcFlag)
                    .IsRequired()
                    .HasColumnName("PC_FLAG")
                    .IsUnicode(false);

                entity.Property(e => e.PhyCity)
                    .IsRequired()
                    .HasColumnName("PHY_CITY")
                    .IsUnicode(false);

                entity.Property(e => e.PhyCountry)
                    .IsRequired()
                    .HasColumnName("PHY_COUNTRY")
                    .IsUnicode(false);

                entity.Property(e => e.PhyState)
                    .IsRequired()
                    .HasColumnName("PHY_STATE")
                    .IsUnicode(false);

                entity.Property(e => e.PhyStreet)
                    .IsRequired()
                    .HasColumnName("PHY_STREET")
                    .IsUnicode(false);

                entity.Property(e => e.PhyZip)
                    .IsRequired()
                    .HasColumnName("PHY_ZIP")
                    .IsUnicode(false);

                entity.Property(e => e.Telephone)
                    .HasColumnName("TELEPHONE")
                    .IsUnicode(false);
            });

            modelBuilder.Entity<Oos>(entity =>
            {
                entity.HasKey(e => e.OosNum)
                    .HasName("PK__OOS__0A5756F47706074C");

                entity.ToTable("OOS");

                entity.Property(e => e.OosNum).HasColumnName("OOS_Num");

                entity.Property(e => e.City)
                    .HasColumnName("city")
                    .HasMaxLength(30)
                    .IsUnicode(false);

                entity.Property(e => e.Gpslatitude)
                    .HasColumnName("GPSLatitude")
                    .HasColumnType("decimal(9, 6)");

                entity.Property(e => e.Gpslongitude)
                    .HasColumnName("GPSLongitude")
                    .HasColumnType("decimal(9, 6)");

                entity.Property(e => e.LegalName)
                    .HasColumnName("legal_name")
                    .HasMaxLength(100)
                    .IsUnicode(false);

                entity.Property(e => e.OosDate)
                    .HasColumnName("oos_date")
                    .HasColumnType("date");

                entity.Property(e => e.OosReason)
                    .HasColumnName("oos_reason")
                    .HasMaxLength(50)
                    .IsUnicode(false);

                entity.Property(e => e.State)
                    .HasColumnName("state")
                    .HasMaxLength(10)
                    .IsUnicode(false);

                entity.Property(e => e.Status)
                    .HasColumnName("status")
                    .HasMaxLength(30)
                    .IsUnicode(false);

                entity.Property(e => e.Street)
                    .HasColumnName("street")
                    .HasMaxLength(100)
                    .IsUnicode(false);

                entity.Property(e => e.Usdot).HasColumnName("USDOT#");

                entity.Property(e => e.Zip)
                    .HasColumnName("zip")
                    .HasMaxLength(6)
                    .IsUnicode(false);
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
