using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft;
using Newtonsoft.Json;

namespace ColoradoTrucking.Data {

    public class FeatureCollection {
        public string type = "Feature Collection";
        public List<Feature> Features { get; set; }

        public FeatureCollection(List<Feature> feat) {
            Features = feat;
        }
    }

    [ComplexType]
    public class Feature {
        private string type = "Feature";
        public Geometry Geometry { get; set; }
        public Properties Properties { get; set; }
        public string Type { get => type; set => type = value; }

        public Feature(Geometry g, Properties p) {
            Geometry = g;
            Properties = p;
        }

    }

    [ComplexType]
    public class Properties {
        [Column("LEGAL_NAME")]
        public string Name { get; set; }
        [Column("PHY_STREET")]
        public string Street { get; set; }
        [Column("PHY_CITY")]
        public string City { get; set; }
        [Column("PHY_STATE")]
        public string State { get; set; }
        [Column("PHY_ZIP")]
        public string Zip { get; set; }
        [Column("TELEPHONE")]
        public string Phone { get; set; }
        [Column("EMAIL_ADDRESS")]
        public string Email { get; set; }

        public Properties(string name, string street, string city, string state, string zip, string phone, string email) {
            this.Name = name;
            this.Street = street;
            this.City = city;
            this.State = state;
            this.Zip = zip;
            this.Phone = phone;
            this.Email = email;
        }
    }

    [ComplexType]
    public class Geometry {
        private string type = "Point";

        [Column("GPSLatitude"), JsonIgnore]
        public double Lat { get; set; }

        [Column("GPSLongitude"), JsonIgnore]
        public double Lng { get; set; }

        public double[] Coordinates { get; set; }
        public string Type { get => type; set => type = value; }

        public Geometry() {
            Coordinates = new double[] { Lat, Lng };
        }
    }
    
}
