import java.util.*;
public class Main {
    public static void ifNoLoaderFound(List<Loader> loaders,  BigCruise br) {
        int id = loaders.size();
        if((id + 1)% 3 == 0) {
            loaders.add(new RecycledLoader(id));
            RecycledLoader recycledLoader = (RecycledLoader) loaders.get(id);
            recycledLoader.loadShip(br);
        } else {
            loaders.add(new Loader(id));
            loaders.get(id).loadShip(br);
        }
    }

    public static void ifNoLoaderFound(List<Loader> loaders, Cruise cr) {
        int id = loaders.size();
        if((id + 1) % 3 == 0) {
            loaders.add(new RecycledLoader(id));
            RecycledLoader recycledLoader  = (RecycledLoader) loaders.get(id);
            recycledLoader.loadShip(cr);
        } else {
            loaders.add(new Loader(id));
            loaders.get(id).loadShip(cr);

        }
    }				

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Loader> loaders = new ArrayList<>();
        int noOfLines = scanner.nextInt();
        int noOfCruises = 0, noOfBigCruises = 0, noOfLoaders = 0, noOfRecycledLoaders = 0;

        for(int i = 0; i < noOfLines; i++) {

            boolean foundLoader1 = false;
            boolean foundLoader2 = false;
            String name = scanner.next();
            String time = scanner.next();
            int timeint = Integer.parseInt(time);
            int minutes = (timeint / 100) * 60 + (timeint % 100);
            if(name.charAt(0) == 'B') {
                noOfBigCruises++;
                BigCruise br = new BigCruise(name, time);
                for(int j = 0; j < loaders.size(); j++) {
                    if(loaders.get(j).getTimer() <= minutes) {
                        loaders.get(j).loadShip(br);
                        foundLoader1 = true;
                        for(int k = j + 1; k < loaders.size() + j + 1; k++) {
                            if(loaders.get(k % loaders.size()).getTimer() <= minutes) {
                                loaders.get(k % loaders.size()).loadShip(br);
                                foundLoader2  = true;
                                break;
                            }
                        } if(!foundLoader2) {
                            ifNoLoaderFound(loaders, br);

                        }

                        break;
                    } 

                }
                if(!(foundLoader1)) {
                    ifNoLoaderFound(loaders, br);
                    ifNoLoaderFound(loaders, br);
                }

            } 
            else {
                noOfCruises++;
                Cruise cr = new Cruise(name, time);
                for(int j = 0; j < loaders.size(); j++) {
                    if(loaders.get(j).getTimer() <= minutes) {
                        loaders.get(j).loadShip(cr); 
                        foundLoader1 = true;
                        break;
                    }
                } 

                if(foundLoader1 == false) {
                    ifNoLoaderFound(loaders, cr);
                }

            }}

        noOfRecycledLoaders = loaders.size() / 3;
        noOfLoaders = loaders.size() - noOfRecycledLoaders;

        System.out.print("+");
        for(int i = 0; i < 34; i++) {
            System.out.print("=");
        }
        System.out.println("+");

        System.out.println("| Cruise Statistics                |");
        System.out.print("+");
        for(int i = 0; i < 34; i++) {
            System.out.print("-");
        }
        System.out.println("+");


        System.out.print("| Number of normal cruises   = ");
        System.out.printf("%3d", noOfCruises);
        System.out.println(" |");




        System.out.print("| Number of big cruises      = ");
        System.out.printf("%3d", noOfBigCruises);
        System.out.println(" |");

        System.out.print("+");
        for(int i = 0; i < 34; i++) {
            System.out.print("=");
        }
        System.out.println("+");


        System.out.println("| Equipment statistics             |");
        System.out.print("+");
        for(int i = 0; i < 34; i++) {
            System.out.print("-");
        }
        System.out.println("+");




        System.out.print("| Number of loaders          = ");
        System.out.printf("%3d", noOfLoaders);
        System.out.println(" |");


        System.out.print("| Number of recycled loaders = ");
        System.out.printf("%3d", noOfRecycledLoaders);
        System.out.println(" |");


        System.out.print("+");
        for(int i = 0; i < 34; i++) {
            System.out.print("=");
        }
        System.out.println("+");



        for(int i = 0; i < loaders.size(); i++) {
            if((i + 1) % 3 != 0) {
                loaders.get(i).printLoader();
            }
        } 

        for(int i = 0; i < loaders.size(); i++) {
            if((i + 1) % 3 == 0) {
                loaders.get(i).printLoader();
            }
        }
    }
}
