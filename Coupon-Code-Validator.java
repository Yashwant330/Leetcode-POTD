1class Solution {
2    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
3      List<String>list =new ArrayList<>();
4        List<String>liste =new ArrayList<>();
5        List<String>listg =new ArrayList<>();
6        List<String>listp =new ArrayList<>();
7        List<String>listr =new ArrayList<>();
8        for(int i=0;i<code.length;i++){
9            String cur=code[i];
10            if(cur.isEmpty())continue;
11            if(!stringCheck(cur))continue;
12            if(businessLine[i].equals("electronics")&&isActive[i])liste.add(cur);
13            if(businessLine[i].equals("grocery")&&isActive[i])listg.add(cur);
14            if(businessLine[i].equals("pharmacy")&&isActive[i])listp.add(cur);
15            if(businessLine[i].equals("restaurant")&&isActive[i])listr.add(cur);
16        }
17        Collections.sort(liste);
18        Collections.sort(listg);
19        Collections.sort(listp);
20        Collections.sort(listr);
21        list.addAll(liste);
22        list.addAll(listg);
23        list.addAll(listp);
24        list.addAll(listr);
25        return list;
26    }
27    public boolean stringCheck(String cur){
28        for(char c:cur.toCharArray()){
29            if(!(Character.isLetterOrDigit(c)||c=='_')){
30                return false;
31            }
32        }
33        return true;
34    }
35}