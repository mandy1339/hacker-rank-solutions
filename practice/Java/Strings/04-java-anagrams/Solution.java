    static boolean isAnagram(String a, String b) {
        // Complete the function
       if (a.length()!=b.length()) {
            return false;
        }

        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        
        int[] freqA = new int[125];
        int[] freqB = new int[125];
        
        
        for(char c : arrA) {
            char lowerC = (int)c <= 90 ? (char)((int)c + 32) : c;    
            freqA[lowerC]++;
        }
        for(char c : arrB) {
            char lowerC = (int)c <= 90 ? (char)((int)c + 32) : c;
            freqB[lowerC]++;
        }

        boolean anagrams = true;
        for(int i = 0; i < freqA.length; i++) {
            if(freqA[i] != freqB[i]) {
                anagrams = false;
                break;
            }
        }
        

        return anagrams? true : false;
        
    }
