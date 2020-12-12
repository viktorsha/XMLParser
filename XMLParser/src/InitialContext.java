public class InitialContext {
    public Object lookup(String serviceName)
    {
        if(serviceName.equalsIgnoreCase("DOM parser"))
        {
            return new ReadDOM();
        }
        else if (serviceName.equalsIgnoreCase("SAX parser"))
        {
            return new ReadSAX();
        }
        return null;
    }
}
