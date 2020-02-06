using System;
using System.Collections.Generic;
using System.Text;

namespace Geocode_SQL
{
    class OOS_Data
    {
        public string USDOT;
        public string legalName;
        public string state;
        public string city;
        public string street;
        public string zip;
        public string oosReason;
        public string oosDate;
        public string status;
        public string lat;
        public string lon;

        public OOS_Data(string uSDOT, string legalName, string state, string city, string street, string zip, string oosReason, string oosDate, string status)
        {
            USDOT = uSDOT;
            this.legalName = legalName;
            this.state = state;
            this.city = city;
            this.street = street;
            this.zip = zip;
            this.oosReason = oosReason;
            this.oosDate = oosDate;
            this.status = status;
        }
    }
}
