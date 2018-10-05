package dao;

import java.io.*;
import java.util.ArrayList;

public class DaoArrayListGenerrico<T> {
    public static<T> ArrayList<T> getEstrutura(File file) throws FileNotFoundException, IOException, ClassNotFoundException{

        if(file.length()>0) {
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)) ){
                return (ArrayList<T>)in.readObject();
            }
        }
        return new ArrayList<T>();
    }

    public static<T> void push(ArrayList<T> obj, File file) throws FileNotFoundException, IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(obj);
        }
    }
}
