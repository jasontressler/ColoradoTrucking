This is the API that does the data transfer between the app and the database. 

The app sends a search term through the API which calls a stored procedure in the database
and transforms the data into geojson to be consumed by Google Maps.

Takes advantage of the browser cache to save results and save the database from multiple
hits with the same query.