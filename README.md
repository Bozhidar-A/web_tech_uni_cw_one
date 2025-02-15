# web_tech_uni_cw_one

Project Title: Web Technologies Coursework One

Created for university coursework. The project has a form to add a new vehicle, a table to display all vehicles. RESTful API can get one vehicle, get all vehicles, add a vehicle. These are the requirements for the coursework.

Used technologies: Java, Maven, Servlet, RESTful API, HTML, TomEE, Eclipse.

Sister project: [web_tech_uni_cw_two](https://github.com/Bozhidar-A/web_tech_uni_cw_two)

## Getting Started

1. Downlaod Java
2. Download Eclipse
3. Download Tomee 9.0.0-M8
4. Add Tomee Server to Eclipse
5. Run the project on the server

## Usage

- Show the main form to add a new vehicle and display all vehicles
  - URL: http://localhost:8080/web_tech_uni_cw_one/
- RESTful API
  - Get all vehicles
    - URL: GET http://localhost:8080/web_tech_uni_cw_one/webapi/db/
  - Get one vehicle
    - URL: GET http://localhost:8080/web_tech_uni_cw_one/webapi/db/{num}
  - Post a vehicle
    - URL: POST http://localhost:8080/web_tech_uni_cw_one/webapi/db/
    - Body raw: ```{"make": "BMW", "model": "Pantheon", "maxPassangers": 5, "manufactureYear": 2018, "gasUsage": 30, "color": "Blue" "gearboxType": "manual" }```