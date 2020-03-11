
# Run the application and follow this instructions:
1. Open your browser and type 'http://localhost:8080' to enter the toll page
2. To enter on the toll prices table, type 'http://localhost:8080/rest/toll/prices'

# Toll payment instructions for normal vehicles:
1. The available types of vehicles are: bus | bike | motorcycle | car | truck
2. To pay the toll of a vehicle other than a truck, type 'http://localhost:8080/rest/toll/pay/{vehicleType}/{paymentValue}

# Toll payment instructions for trucks with additional axles:
1. Trucks may have more axles, which have an additional cost per unit.
2. To pay the toll of a truck with additional axles, type 'http://localhost:8080/rest/toll/pay/truck/{numberOfAdditionalAxles}/{paymentValue}
