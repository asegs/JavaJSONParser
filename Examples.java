public class Driver {
    public static void main(String[] args) {
        Parser p = new Parser();
        String carsJSON = "{'name':'John','age':30,'cars': {'car1':'Ford','carData':'BMW','car3':'Fiat','interior':{'material':'leather','color':'blue','keys':{'digital':'yes','physical':'no'}}},'carList':['carData','system','colors','materials':{'color':'blue'}],'carData':{'colors':'yellow','name':'Chrysler'}}";
        p.deepJSON(carsJSON,"name",true);
        //'name':'John'
        p.deepJSON(carsJSON,"age",false);
        //30
        p.deepJSON(carsJSON,"cars",true);
        //'cars':{'car1':'Ford','carData':'BMW','car3':'Fiat','interior':{'material':'leather','color':'blue','keys':{'digital':'yes','physical':'no'}}}
        p.deepJSON(carsJSON,"carList.materials",false);
        //{'color':'blue'}
        p.deepJSON(carsJSON,"cars.interior.keys.digital",true);
        //'digital':'yes'
    }
}
