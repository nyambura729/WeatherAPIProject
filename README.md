# WeatherAPIProject

**This project provides a framework for testing the Current Weather section of the Open Weather API**

The project is split into 3 packages: Connection, DTO and Injection which contain the code which allows for connection to the API, and creation of Data Transfer Objects which have been mapped to response body values from API calls. Separate to these packages are a set of test classes which can be used for testing the responses from API calls.

In particular, the test class WeatherAPIFrameworkTests contains tests pertaining to the framework itself. All other test classes are to be used for testing the API.
