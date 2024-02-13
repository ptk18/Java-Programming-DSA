public class Dog{
        private String breed;
        private int magicValue;

        public Dog(String n)
        {
            breed = n;
            int v = 0;
            for (int i = 0; i < n.length(); i++)
                v += n.charAt(i);
            magicValue = v;
        }
        
        @Override
        public String toString()
        {
            return breed + "(" + magicValue + ")";
        }

        public String getBreed()
        {
            return breed;
        }

        public int getMagicValue()
        {
            return magicValue;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((breed == null) ? 0 : breed.hashCode());
            result = prime * result + magicValue;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Dog other = (Dog) obj;
            if (breed == null) {
                if (other.breed != null)
                    return false;
            } else if (!breed.equals(other.breed))
                return false;
            if (magicValue != other.magicValue)
                return false;
            return true;
        }

 
    
}
