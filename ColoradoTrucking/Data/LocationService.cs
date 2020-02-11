using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using System.Threading;
using System.Threading.Tasks;

namespace ColoradoTrucking.Data {
    public class LocationService : ILocationService
    {
        private readonly HttpClient _httpClient;

        public LocationService(HttpClient httpClient) {
            _httpClient = httpClient;
            _httpClient.BaseAddress = new Uri("http://localhost:8080/");
        }

        public async Task<List<string>> GetCompanyNames(string search) {
            using var response = await _httpClient.GetAsync($"search/?query={search}");
            using var responseStream = await response.Content.ReadAsStreamAsync();
            return await JsonSerializer.DeserializeAsync<List<String>>(responseStream);
        }
    }
}
