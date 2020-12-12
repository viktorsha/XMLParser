import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<IParser> parserList = new ArrayList<>();

    public IParser getParser(String parserType)
    {
       if (parserList.contains(parserType))
       {
           return parserList.get(parserList.indexOf(parserType));
       }
       return null;
    }
    public void addParser(IParser newParser)
    {
        parserList.add(newParser);
    }
}
