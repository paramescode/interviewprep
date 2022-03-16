import com.sun.javadoc.SeeTag;

public class DistanceConvertor {


    public enum DistanceUnit{

        INCHES{
            public  double toInches(double distance){
                return distance;
            }

            public  double toFoots(double distance){
                return distance / C1;
            }

            public  double toMeters(double distance){
                return distance / C2;
            }

            public  double toKiloMeters(double distance){
                return distance / C3;
            }

            public  double toMiles(double distance){
                return distance / C4;
            }

            public  double convert(double distance, DistanceUnit sourceUnit){
                return sourceUnit.toInches(distance);
            }
        },

        FOOTS{
            public  double toInches(double distance){
                return distance *  12;
            }

            public  double toFoots(double distance){
                return distance;
            }

            public  double toMeters(double distance){
                return distance / 3.281 ;
            }

            public  double toKiloMeters(double distance){
                return distance / (3.281 * 1000) ;
            }

            public  double toMiles(double distance){
                return distance / (3.281 * 1000 * 1.609);
            }

            public  double convert(double distance, DistanceUnit sourceUnit){
                return sourceUnit.toFoots(distance);
            }
        },

        METERS{
            public  double toInches(double distance){
                return distance  * (3.281 * 12) ;
            }

            public  double toFoots(double distance){
                return distance / 3.281;
            }

            public  double toMeters(double distance){
                return distance;
            }

            public  double toKiloMeters(double distance){
                return distance / 1000;
            }

            public  double toMiles(double distance){
                return distance / (1000 * 1.609);
            }

            public  double convert(double distance, DistanceUnit sourceUnit){
                return sourceUnit.toMeters(distance);
            }
        },

        KILOMETERS{
            public  double toInches(double distance){
                return distance * (1000 * 3.281 * 12);
            }

            public  double toFoots(double distance){
                return distance * 1000 * 3.281;
            }

            public  double toMeters(double distance){
                return distance * 1000;
            }

            public  double toKiloMeters(double distance){
                return distance;
            }

            public  double toMiles(double distance){
                return distance / 1.609;
            }

            public  double convert(double distance, DistanceUnit sourceUnit){
                return sourceUnit.toKiloMeters(distance);
            }
        },
        MILES{
            public  double toInches(double distance){
                return distance * 1.609 * 1000 * 3.281 * 12;
            }

            public  double toFoots(double distance){
                return distance * 1.609 * 1000 * 3.281;
            }

            public  double toMeters(double distance){
                return distance * 1.609 * 1000 ;
            }

            public  double toKiloMeters(double distance){
                return distance * 1.609 ;
            }

            public  double toMiles(double distance){
                return distance;
            }

            public  double convert(double distance, DistanceUnit sourceUnit){
                return sourceUnit.toMiles(distance);
            }
        };

         static double C0 = 1d; // inch
        static double C1 = C0 * 12; // feet, 12 inch = 1 feet
        static double C2 = C1 * 3.281; // 3.281 feet = 1 Meter
        static double C3 =  C2 * 1000; // 1000 M = 1 KM
        static double C4 =  C3 * 1.609; // 1.6 Km = 1 Mile


        public abstract double toInches(double distance);

        public abstract double toFoots(double distance);

        public abstract double toMeters(double distance);

        public abstract double toKiloMeters(double distance);

        public abstract double toMiles(double distance);

        public abstract double convert(double distance, DistanceUnit distanceUnit);
    }

    public static void main(String[] args) {
        System.out.println( DistanceUnit.MILES.toKiloMeters(1));
        System.out.println( DistanceUnit.MILES.toMeters(1));
        System.out.println( DistanceUnit.MILES.toFoots(1));
        System.out.println( DistanceUnit.MILES.toInches(1));
        System.out.println( DistanceUnit.MILES.convert(1, DistanceUnit.KILOMETERS));
        System.out.println("--------------");
        System.out.println( DistanceUnit.KILOMETERS.convert(1, DistanceUnit.MILES));

        System.out.println("--------------");

        System.out.println( DistanceUnit.METERS.toKiloMeters(1));
        System.out.println( DistanceUnit.METERS.toMiles(1));
        System.out.println( DistanceUnit.METERS.toInches(1));

        System.out.println("--------------");

        System.out.println( DistanceUnit.INCHES.toKiloMeters(1));
        System.out.println( DistanceUnit.INCHES.toMiles(1));
        System.out.println( DistanceUnit.INCHES.toFoots(1));
        System.out.println( DistanceUnit.INCHES.toMeters(1));
    }



}
