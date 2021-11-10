import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProductRepository {
    public ArrayList<Product> getData(){
        ArrayList<Product> list = new ArrayList<>();

        try{
            Gson gson = new Gson();
            FileReader reader = new FileReader("products.json");
            Type objectType = new TypeToken<ArrayList<Product>>(){}.getType();
            list = gson.fromJson(reader, objectType);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return list;
    }
}
