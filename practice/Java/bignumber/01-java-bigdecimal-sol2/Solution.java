        //Write your code here
        String[] arr2 = Arrays.copyOf(s, n);
        Arrays.sort(s, 0, n, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return new BigDecimal(o2).compareTo(new BigDecimal(o1)); 
            }
        });
        
