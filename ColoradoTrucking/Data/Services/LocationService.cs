using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading;
using System.Threading.Tasks;
using ColoradoTrucking.Data.Responses;

namespace ColoradoTrucking.Data.Services {
    public class LocationService : ILocationService {
        private readonly HttpClient _httpClient;

        public LocationService(HttpClient httpClient) {
            _httpClient = httpClient;
            _httpClient.BaseAddress = new Uri("https://locationclient.azurewebsites.net");

            //Development URI
            //_httpClient.BaseAddress = new Uri("http://localhost:9090/");
        }

        public async Task<FeatureResponse> GetCompaniesAsync(string search) {
            using var response = await _httpClient.GetAsync($"search/?query={search}");
            using var responseStream = await response.Content.ReadAsStreamAsync();
            return await JsonSerializer.DeserializeAsync<FeatureResponse>(responseStream);
        }

        public async Task<FeatureResponse> GetCompaniesAsync(string search, CancellationToken cancellationToken) {
            using var response = await _httpClient.GetAsync($"search/?query={search}", cancellationToken);
            using var responseStream = await response.Content.ReadAsStreamAsync();
            return await JsonSerializer.DeserializeAsync<FeatureResponse>(responseStream, cancellationToken: cancellationToken);
        }

        
    }
}
