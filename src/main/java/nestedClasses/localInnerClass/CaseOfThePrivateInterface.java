package nestedClasses.localInnerClass;


public class CaseOfThePrivateInterface {

    /** Private interfaces are legal! as long as they are an inner interface **/
    private interface Secret {
        public void shh();
    }

    class DontTell implements Secret {
        @Override
        public void shh() {
            System.out.println("Shhhh!");
        }
    }
}
