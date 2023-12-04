class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        
        Set<String> set = Arrays.stream(wordList).map(word -> word).collect(java.util.stream.Collectors.toSet());
        
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(startWord));
        
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            List<String> list = queue.remove();
            String pattern = list.get(list.size() - 1);
            set.remove(pattern);
            
            for (int i = 0; i < pattern.length(); i++) {
                StringBuilder word = new StringBuilder(pattern);
                for (int ch = 97; ch < 123; ch++) {
                    word.setCharAt(i, (char)ch);
                    if (set.remove(word.toString())) {
                        set.add(word.toString());
                        ArrayList<String> newList = new ArrayList<>(list);
                        newList.add(word.toString());
                        if (word.toString().equals(targetWord)) {
                            if (newList.size() < min) {
                                res.clear();
                                min = newList.size();
                            } else if (newList.size() > min){
                                continue;
                            }
                            res.add(newList);
                        }
                        queue.add(newList);
                    }
                }
            }
        }
        
        return res;
    }
}
