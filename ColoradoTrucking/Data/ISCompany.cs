using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Globalization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;

namespace ColoradoTrucking.Data {

    public partial class ISCompany {
        [JsonProperty("DOT_NUMBER")]
        public long DotNumber { get; set; }

        [JsonProperty("LEGAL_NAME")]
        public string LegalName { get; set; }

        [JsonProperty("DBA_NAME")]
        public string DbaName { get; set; }

        [JsonProperty("CARRIER_OPERATION")]
        public string CarrierOperation { get; set; }

        [JsonProperty("HM_FLAG")]
        public string HmFlag { get; set; }

        [JsonProperty("PC_FLAG")]
        public string PcFlag { get; set; }

        [JsonProperty("PHY_STREET")]
        public string PhyStreet { get; set; }

        [JsonProperty("PHY_CITY")]
        public string PhyCity { get; set; }

        [JsonProperty("PHY_STATE")]
        public string PhyState { get; set; }

        [JsonProperty("PHY_ZIP")]
        public long PhyZip { get; set; }

        [JsonProperty("PHY_COUNTRY")]
        public string PhyCountry { get; set; }

        [JsonProperty("MAILING_STREET")]
        public string MailingStreet { get; set; }

        [JsonProperty("MAILING_CITY")]
        public string MailingCity { get; set; }

        [JsonProperty("MAILING_STATE")]
        public string MailingState { get; set; }

        [JsonProperty("MAILING_ZIP")]
        public long MailingZip { get; set; }

        [JsonProperty("MAILING_COUNTRY")]
        public string MailingCountry { get; set; }

        [JsonProperty("TELEPHONE")]
        public string Telephone { get; set; }

        [JsonProperty("FAX")]
        public string Fax { get; set; }

        [JsonProperty("EMAIL_ADDRESS")]
        public string EmailAddress { get; set; }

        [JsonProperty("MCS150_DATE")]
        public string Mcs150Date { get; set; }

        [JsonProperty("MCS150_MILEAGE")]
        public long Mcs150Mileage { get; set; }

        [JsonProperty("MCS150_MILEAGE_YEAR")]
        public long Mcs150MileageYear { get; set; }

        [JsonProperty("ADD_DATE")]
        public string AddDate { get; set; }

        [JsonProperty("OIC_STATE")]
        public string OicState { get; set; }

        [JsonProperty("NBR_POWER_UNIT")]
        public long NbrPowerUnit { get; set; }

        [JsonProperty("DRIVER_TOTAL")]
        public long DriverTotal { get; set; }

        [JsonProperty("GPSLatitude")]
        public double GpsLatitude { get; set; }

        [JsonProperty("GPSLongitude")]
        public double GpsLongitude { get; set; }
    }
}
