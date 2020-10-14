import java.util.*;

interface IDataRepository{
    
    public boolean create(String path, String data);
    public boolean update(String path, String data);
    public boolean delete(String path);
    public String get(String path);
    public ArrayList<String> list(String path);
}