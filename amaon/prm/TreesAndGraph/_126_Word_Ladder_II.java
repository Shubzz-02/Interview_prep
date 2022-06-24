package com.company.amaon.prm.TreesAndGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _126_Word_Ladder_II {

    public static void main(String[] args) {
        String beginWord = "cet", endWord = "ism";
        List<String> wordList = List.of("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim");
        new _126_Word_Ladder_II().findLadders(beginWord, endWord, wordList).forEach(
                System.out::println);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();

        Queue<ModPair<String, List<String>, Set<String>>> queue = new LinkedList<>();
        Set<String> wordListSet = new HashSet<>(wordList);
        queue.add(new ModPair<>(beginWord, new ArrayList<>(), new HashSet<>(
                Collections.singleton(beginWord))));
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue.size());
            for (int s = 0; s < size; s++) {
                ModPair<String, List<String>, Set<String>> cp = queue.remove();
                String cw = cp.getKey();
                List<String> cList = cp.getValue();
                Set<String> vis = cp.getSet();
                cList.add(cw);
                if (cw.equals(endWord)) {
                    if (cList.size() <= min) {
                        ans.add(cList);
                        min = cList.size();
                    }
                }
                char[] arr = cw.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char ch = arr[i];

                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String temp = new String(arr);
                        if (!vis.contains(temp) && !temp.equals(beginWord)
                                && wordListSet.contains(temp) && cList.size() <= min) {
                            vis.add(temp);
                            queue.add(new ModPair<>(temp, new ArrayList<>(cList),
                                    new HashSet<>(vis)));
                        }
                    }
                    arr[i] = ch;
                }
            }
        }
        return ans;
    }

    class ModPair<K, V, S> {

        private K key;
        private V value;
        private S set;

        public ModPair(K key, V value, S set) {
            this.key = key;
            this.value = value;
            this.set = set;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public S getSet() {
            return set;
        }
    }

}
