using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.Common;
using System.Data.SqlClient;
using System.IO;

namespace Geocode_SQL
{
    class Program
    {
        public static string conString = "Data Source=DESKTOP-7A019VO;Initial Catalog=EnterpriseDB;Integrated Security=True;MultipleActiveResultSets=true";
        public static List<OOS_Data> rawData = new List<OOS_Data>();
        public static List<OOS_Data> cleanData = new List<OOS_Data>();
        static void Main(string[] args)
        {
            getData();
            getGPSData();
            createSQLFile();
        }

        public static void getData()
        {
            using (SqlConnection con = new SqlConnection(conString))
            {
                con.Open();
                SqlCommand myCommand = new SqlCommand("Select * from OOS", con);
                SqlDataReader dr = myCommand.ExecuteReader();
                
                while (dr.Read())
                {
                    String address = cleanAddress(dr[5].ToString());
                    OOS_Data raw = new OOS_Data(dr[1].ToString(), dr[2].ToString(), dr[3].ToString(), dr[4].ToString().Replace("SPGS", "SPRINGS"), dr[5].ToString(), dr[6].ToString(), dr[7].ToString(), dr[8].ToString(), dr[9].ToString());
                    OOS_Data clean = new OOS_Data(dr[1].ToString(),dr[2].ToString(),dr[3].ToString(),dr[4].ToString().Replace("SPGS","SPRINGS"),address,dr[6].ToString(), dr[7].ToString(), dr[8].ToString(), dr[9].ToString());
                    rawData.Add(raw);
                    cleanData.Add(clean);
                }

            }
        }
        public static void getGPSData()
        {
            using (SqlConnection con = new SqlConnection(conString))
            {
                con.Open();
                for (int i = 0; i < cleanData.Count; i++)
                {
                    String q = String.Format("EXEC spGeocode @Address = '{0}',@City = '{1}',@State = '{2}'",cleanData[i].street,cleanData[i].city,cleanData[i].state);
                    SqlCommand geoCommand = new SqlCommand(q, con);
                    SqlDataReader dataReader = geoCommand.ExecuteReader();
                    while (dataReader.Read())
                    {
                        rawData[i].lat = dataReader[0].ToString();
                        rawData[i].lon = dataReader[1].ToString();
                    }
                    dataReader.Close();
                    geoCommand.ExecuteNonQuery();
                    geoCommand.Parameters.Clear();
                }
                    
            }
            
        }
        public static void createSQLFile()
        {
            String path = "C:\\Users\\jardo\\ColoradoSQL\\OOS_Geo_SQL.txt";

            for(int i = 0; i < rawData.Count; i++)
            {
                String insertStmt = String.Format("insert into OOS values('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}')"
                                             ,rawData[i].USDOT, rawData[i].legalName.Replace("'","''").Trim(), rawData[i].state, rawData[i].city, rawData[i].street, 
                                             rawData[i].zip, rawData[i].oosReason, rawData[i].oosDate.Replace(" 12:00:00 AM",""), rawData[i].status, rawData[i].lat, rawData[i].lon);
                using(StreamWriter sw = File.AppendText(path))
                {
                    sw.WriteLine(insertStmt);
                }

            }
        }
        public static string cleanAddress(string address)
        {
            String[] suffixes = { " DRIVE "," CIR " ," LANE ", " STREET ", " AVENUE ", " AVE ", " PL ", " CT ", " COURT ", " BLVD ", " DR ", " ST ", " ROAD ", " RD ", " WAY ", " CIRCLE ", " LOOP " };
            String fixedAddress;
            for(int i = 0; i < suffixes.Length; i++)
            {
                if (address.IndexOf(suffixes[i]) != -1)
                {
                    fixedAddress = address.Substring(0, address.IndexOf(suffixes[i]) + suffixes[i].Length-1);
                  // Console.WriteLine("Old Address: " + address + "\nNew Address: " + fixedAddress+"\n*****************************");
                    return fixedAddress;
                }
            }
            
           //Console.WriteLine("Valid Address: "+address+ "\n*****************************");
            fixedAddress = address;
            return fixedAddress;
        }
    }
}
