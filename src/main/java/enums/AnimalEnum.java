package enums;

public enum AnimalEnum {
    REPTILE(true) {
        @Override
        public boolean humanFriendly() {
            return false;
        }
    },
    DOG(false) {
        @Override
        public boolean humanFriendly() {
            return true;
        }
    };

    private boolean coldBlooded;
    public abstract boolean humanFriendly();
    AnimalEnum(boolean coldBlooded) {
        this.coldBlooded = coldBlooded;
    }


}
