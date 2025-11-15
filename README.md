# Weather API Client
A simple Kotlin console application that fetches and displays weather forecasts for multiple cities using the WeatherAPI.com service.

## Setup & Run**
1. Clone the repository
    ```
    git clone https://github.com/vikmanz/weather-api.git
    cd weather-api
    ```
2. Create configuration file
In the root directory of the project, create a file named `config.properties` with your WeatherAPI key, API url and Cities list.\
This file is ignored by Git via .gitignore, so your key stays private.\
Format:
    ``` 
    # URL of weather API
    api.url=https://api.weatherapi.com/v1/
    # Your API key
    api.key=`your_api_key_here`
    # Cities list
    cities=Chisinau,Madrid,Kyiv,Amsterdam
    ```
3. Run the project
If you’re using Gradle:
    ```
    ./gradlew run
    ```
* Or open the project in IntelliJ IDEA and run the main function in `Main.kt`

## Example Output:
```
City         | Date         | TempMin    | TempMax    | Humidity   | Wind speed (km/h)  | Wind direction
--------------------------------------------------------------------------------------------------------
Chisinau     | 2025-11-13   | 4,4        | 9,4        | 79,0       | 15,8               | NW            
Madrid       | 2025-11-13   | 12,5       | 18,6       | 55,0       | 34,9               | SE            
Kyiv         | 2025-11-13   | 4,9        | 8,2        | 76,0       | 13,3               | SSW           
Amsterdam    | 2025-11-13   | 11,1       | 15,5       | 78,0       | 20,2               | S             


City       | 2025-11-13  
---------------------------------------------------
Chisinau   | ○ Minimum Temperature (°C): 4.4       
           | ○ Maximum Temperature (°C): 9.4       
           | ○ Humidity (%): 79.0                  
           | ○ Wind Speed (kph): 15.8          
           | ○ Wind Direction: NW                  
---------------------------------------------------
Madrid     | ○ Minimum Temperature (°C): 12.5      
           | ○ Maximum Temperature (°C): 18.6      
           | ○ Humidity (%): 55.0                  
           | ○ Wind Speed (kph): 34.9          
           | ○ Wind Direction: SE                  
---------------------------------------------------
Kyiv       | ○ Minimum Temperature (°C): 4.9       
           | ○ Maximum Temperature (°C): 8.2       
           | ○ Humidity (%): 76.0                  
           | ○ Wind Speed (kph): 13.3          
           | ○ Wind Direction: SSW                 
---------------------------------------------------
Amsterdam  | ○ Minimum Temperature (°C): 11.1      
           | ○ Maximum Temperature (°C): 15.5      
           | ○ Humidity (%): 78.0                  
           | ○ Wind Speed (kph): 20.2          
           | ○ Wind Direction: S                   
---------------------------------------------------
```
