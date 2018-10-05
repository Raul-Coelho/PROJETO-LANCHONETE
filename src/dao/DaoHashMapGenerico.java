package dao;

import model.Pessoa;

import java.io.*;
import java.util.HashMap;

public class DaoHashMapGenerico<F extends Pessoa> {
    public static <K, V> HashMap<K, V> getEstrutura(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
        if(file.length()>0) {
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                return (HashMap<K, V>) in.readObject();
            }
        }
        return new HashMap<>();
    }

    public static <V, K> void push(HashMap<K, V> map, File file) throws FileNotFoundException, IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(map);
        }
    }
}
