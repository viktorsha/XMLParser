import java.util.List;
import java.util.Scanner;

public class Main {
    private static ServiceLocator Compose()
    {
        return ServiceLocator.getInstance()
                .register(ParserFactory.class, new ParserFactory());
    }

    public static void main (String[] args) throws Exception {
        var serviceLocator = Compose();
        CreateXML.createXML();
        System.out.println("Which parser would you like to choose: DOM parser or SAX parser?");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        ParserFactory parserFactory = serviceLocator.resolve(ParserFactory.class);
        IParser parser = parserFactory.create(choice);
        List<Developers> developersInfo = parser.getDevelopersInfo();
        DevelopersRepository repository = new DevelopersRepositoryImpl();
        for (int i = 1; i< developersInfo.size(); i++)
        {
            repository.insert(developersInfo.get(i));
        }
        loop: while (!choice.equals("0"))
        {
            System.out.println("Which parser would you like to choose:\n\t1.Insert user to database\n\t" +
                    "2.Update user in database\n\t3.Delete user in database\n\t4.Get all developers\n\t" +
                    "5.Get developer by id\n\t0.Exit");
            input = new Scanner(System.in);
            choice = input.nextLine();
            Developers developer;
            switch (choice)
            {
                case "1":
                    repository.insert(Developers.enterCredentials());
                    break;
                case "2":
                    repository.update(Developers.enterCredentials());
                    break;
                case "3":
                    repository.delete(Developers.enterCredentials().getId());
                    break;
                case "4":
                    developersInfo = repository.findAll();
                    System.out.println("There were found these developers in database");
                    for (Developers developerIter: developersInfo
                         ) {
                        System.out.println(developerIter.getName()+" "+developerIter.getSurname()+
                                " "+developerIter.getAge()+" "+developerIter.getPosition());
                    }
                    break;
                case "5":
                    System.out.println("Enter an id of developer you want to get");
                    input = new Scanner(System.in);
                    choice = input.nextLine();
                    developer = (Developers) repository.findById(choice);
                    System.out.println(developer.getName()+" "+developer.getSurname()+
                            " "+developer.getAge()+" "+developer.getPosition());
                    break;
                case "0":
                    break loop;

            }

        }

    }
}
