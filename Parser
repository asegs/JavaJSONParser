//JSON String examples v

//{'people':[{'name':'Aaron','age':20},{'name':'Gelsomina','age':20}]}


    /*
     {"name":"John","age":30,"cars": {"car1":"Ford","carData":"BMW","car3":"Fiat","interior":{"material":"leather","color":"blue"},'name':"Sports"},"carList":["carData","system","colors","materials":{"color":"blue"}],"carData":{"colors":"yellow","name":"Chrysler"}}
     */

import java.util.ArrayList;

//handle spaces outside of data
public class Parser {


    //Finds all indexes of a certain string in a larger string
    public ArrayList<Integer> getAllOccurrences(String body,String key){
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while (true){
            index = body.indexOf(key,index+1);
            if (index != -1){
                result.add(index);
            }else{
                break;
            }
        }
        return result;
    }

    //Gets the nesting level of index in string
    public int getNesting(String body,int index){
        int bank = 0;
        for (int i = 1;i<index;i++){
            char idxChar = body.charAt(i);
            if (idxChar=='{' || idxChar=='['){
                bank++;
            }else if(idxChar=='}' || idxChar==']'){
                bank--;
            }
        }
        return bank;
    }

    public int getClosingIndex(String body,int index){
        int bank = 0;
        boolean encounteredNestSymbol = false;
        for (int i = index;i<body.length();i++){
            char idxChar = body.charAt(i);
            if (!encounteredNestSymbol && (idxChar=='{' || idxChar=='[')){
                encounteredNestSymbol = true;
                bank++;
            }else if (!encounteredNestSymbol && (idxChar=='}' || idxChar==']')){
                return i;
            } else if(!encounteredNestSymbol && idxChar==','){
                return i;
            }else if(idxChar=='{' || idxChar=='['){
                bank++;
            }else if(idxChar=='}' || idxChar==']'){
                bank--;
                if (bank == 0){
                    return i+1;
                }
            } else if (encounteredNestSymbol && bank == 0){
                return i;
            }
        }
        return -1;
    }

    //Parses JSON
    public String findJSON(String body,String key){
        body = body.stripLeading();
        body = body.stripTrailing();
        //Get all indexes of the key you are looking for
        ArrayList<Integer> indexesOfKey = getAllOccurrences(body,key);
        //Return empty if not found
        if (indexesOfKey.size()==0){
            return "";
        }
        int properNestingIdx = -1;
        //Check if the key is not nested, if so set index to that key's index
        for (Integer i:indexesOfKey){
            if (getNesting(body,i)==0){
                properNestingIdx = i;
            }
        }
        //If key nested, return empty
        if (properNestingIdx == -1){
            return "";
        }
        //Get the closing index for the index of the end of the key
        properNestingIdx+=(key.length()+2);
        int endIndex = getClosingIndex(body,properNestingIdx);
        //If improperly formatted, return empty
        if (endIndex == -1){
            return "";
        }
        return body.substring(properNestingIdx,endIndex);
    }

    public String deepJSON(String body,String keyText){
        String[] tokens = keyText.split("\\.");
        for (String token:tokens){
            body = findJSON(body,token);
        }
        System.out.println(body);
        return body;
    }
}
