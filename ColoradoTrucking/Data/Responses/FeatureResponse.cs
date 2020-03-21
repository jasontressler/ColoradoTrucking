namespace ColoradoTrucking.Data.Responses
{
    using System;
    using System.Collections.Generic;
    using System.Globalization;
    using System.Text.Json;
    using Newtonsoft.Json;
    using Newtonsoft.Json.Converters;
    using System.Net.Http;
    using System.Threading.Tasks;

    public partial class FeatureResponse : Response
    {
        [JsonProperty("message")]
        public string message { get; set; }

        [JsonProperty("body")]
        public Body body { get; set; }
    }

    public partial class Body
    {
        [JsonProperty("type")]
        public string type { get; set; }

        [JsonProperty("features")]
        public List<Feature> features { get; set; }

        public Body() { }

        public Body(List<Feature> features) {
            this.type = "FeatureCollection";
            this.features = features;
        }
    }

    public partial class Feature
    {
        [JsonProperty("type")]
        public string type { get; set; }

        [JsonProperty("properties")]
        public Properties properties { get; set; }

        [JsonProperty("geometry")]
        public Geometry geometry { get; set; }

        public override string ToString() {
            return $"{properties.name} {properties.GetAddress()}";
        }
    }

    public partial class Geometry
    {
        [JsonProperty("coordinates")]
        public List<double> coordinates { get; set; }
    }

    public partial class Properties
    {
        [JsonProperty("id")]
        public long id { get; set; }

        [JsonProperty("name")]
        public string name { get; set; }

        [JsonProperty("street")]
        public string street { get; set; }

        [JsonProperty("city")]
        public string city { get; set; }

        [JsonProperty("state")]
        public string state { get; set; }

        [JsonProperty("zip")]
        public string zip { get; set; }

        [JsonProperty("phone")]
        public string phone { get; set; }

        [JsonProperty("email")]
        public string email { get; set; }

        [JsonProperty("distance")]
        public double distance { get; set; }

        [JsonProperty("Nearest_OSName")]
        public String nearestOSName { get; set; }

        [JsonProperty("OS_lat")]
        public double OS_Lat { get; set; }

        [JsonProperty("IS_Lat")]
        public double OS_Long { get; set; }

        public string GetAddress() {
            return String.Format($"{street}, {city}, {state} {zip}");
        }
    }

    public partial class FeatureResponse
    {
        public static FeatureResponse FromJson(string json) => JsonConvert.DeserializeObject<FeatureResponse>(json, ColoradoTrucking.Data.Responses.Converter.Settings);
    }

    public static class Serialize
    {
        public static string ToJson(this FeatureResponse self) => JsonConvert.SerializeObject(self, Converter.Settings);
    }

    internal static class Converter
    {
        public static readonly JsonSerializerSettings Settings = new JsonSerializerSettings
        {
            MetadataPropertyHandling = MetadataPropertyHandling.Ignore,
            DateParseHandling = DateParseHandling.None,
            Converters =
            {
                new IsoDateTimeConverter { DateTimeStyles = DateTimeStyles.AssumeUniversal }
            },
        };
    }
}
