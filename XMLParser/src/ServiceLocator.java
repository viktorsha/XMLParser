public class ServiceLocator {
    private static Cache cache = new Cache();
    public static IParser getParser(String parserType)
    {
        IParser parser = cache.getParser(parserType);
        if (parser!=null)
        {
            return parser;
        }
        InitialContext context = new InitialContext();
        IParser parser1 = (IParser) context.lookup(parserType);
        cache.addParser(parser1);
        return parser1;
    }
}
