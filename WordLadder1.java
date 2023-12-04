class Solution
{
    class Data {
        String word;
        int count;
        
        public Data(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String> set = Arrays.stream(wordList).map(word -> word).collect(java.util.stream.Collectors.toSet());
        
        
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(startWord, 1));
        set.remove(startWord);
        
        while (!queue.isEmpty()) {
           Data data =  queue.remove();
           for (int i = 0; i < data.word.length(); i++) {
               StringBuilder word = new StringBuilder(data.word);
               for (int ch = 97; ch < 123; ch++) {
                   word.setCharAt(i, (char)ch);
                   if (set.remove(word.toString())) {
                       if (word.toString().equals(targetWord)) {
                           return data.count + 1;
                       }
                       queue.add(new Data(word.toString(), data.count + 1));
                   }
               }
           }
        }
        
        return 0;
    }
}
