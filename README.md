# EnterpriseApps

The purpose of this app is to provide an interface for users to search a database of trucking companies in Colorado and determine whether or not they are a chameleon company. 

The app features an interactive Google map to provide visual location to the user and color-coded markers denoting their likeliness to be a chameleon company. Red markers are the most likely, green are least. Additionally, those that perceived to possibly be a chameleon give information about the previous company. A table below the map gives a textual representation of the query results for easier comparison. The underlying database is fully geofenced so that the user may search by company name, street address, city, or zip code. (State was excluded since the app is specific to Colorado.)

The search box has an search-as-you-type functionality that actively hits the databases to return relevant suggestions to search. Because of higher concentrations of companies in major cities, we also included filters to cut back on processing demands and increase performance.

This app was built in Microsoft's Blazor framework. The web app, the API, and the database are fully hosted on Azure.
