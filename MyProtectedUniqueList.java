import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

public class MyProtectedUniqueList<T> implements Comparable ,Iterable<T>
{
    List<T> myList;
    String codeWord;
    private int count=0;
    Iterator<T> iterator=new Iterator<>() {
        private int counter;
        @Override
        public boolean hasNext() {
            return (counter<count);
        }
        @Override
        public T next() {
            return myList.get(counter++);
        }
    };

    public MyProtectedUniqueList(String codeWord)
    {
        myList=new ArrayList<>();
        setCodeWord(codeWord);
    }

    private String getCodeWord() {
        return codeWord;
    }

    private void setCodeWord(String codeWord) {
        this.codeWord = codeWord;
    }
    public void add(String codeWord,T wordTuAdd) throws Exception
    {
        if (!codeWord.equals(getCodeWord()))
        {
            throw new Exception("wrong code word. you have no right to use this class");
        }
        else if(wordTuAdd.equals(null))
        {
            throw new Exception("you didn't enter a proper word to add. i do not want to add that.");
        }
        else
        {
            myList.add(wordTuAdd);
        }
    }
    public void remove(String codeWord,T wordTuRemove) throws Exception
    {
        if (!codeWord.equals(getCodeWord()))
        {
            throw new Exception("wrong code word. you have no right to use this class");
        }
        else if(wordTuRemove.equals(null))
        {
            throw new Exception("you didn't enter a proper word to remove. I do not want to remove that.");
        }
        else
        {
            myList.remove(wordTuRemove);
        }
    }
    public void removeAt(String codeWord,int index) throws Exception
    {
        if (!codeWord.equals(getCodeWord()))
        {
            throw new Exception("wrong code word. you have no right to use this class");
        }
        else if(index<0||index>myList.size())
        {
            throw new Exception("you didn't enter a proper index to remove. " +
                    "I do not now what to do with that kind of index. Maybe it is bigger then the size of the list? " +
                    "The size is " + myList.size() +
                    "By the way, I have no negative indexes");
        }
        else
        {
            myList.remove(index);
        }
    }
    public void clear(String codeWord) throws Exception
    {
        if (!codeWord.equals(getCodeWord()))
        {
            throw new Exception("wrong code word. you have no right to use this class");
        }
        else
        {
            myList.clear();
        }
    }
    public void sort(String codeWord,int index) throws Exception
    {
        if (!codeWord.equals(getCodeWord()))
        {
            throw new Exception("wrong code word. you have no right to use this class");
        }
        else {
//            Collections.sort(myList, new Comparator<String>()
//            {
//                @Override
//                public int compare(String o1, String o2)
//                {
//                    return o1.compareTo(o2);
//                }
//            });
            Collections.sort(myList, new Comparator<T>()
            {
                @Override
                public int compare(T o1, T o2)
                {
                    return o1.compareTo(o2);
                }
            });
            for (int i = 0; i < myList.size(); i++) {
                for (int j = 1; j < myList.size(); j++) {
                    if(myList.get(i).compareTo(myList.get(j))==0)
                        myList.remove(j);
                }
            }

        }
    }
    @Override
    public Iterator iterator() {
        return iterator;
    }

    @Override
    //can't compare normally because of need for two objects, possible or without getting the object in the signature or getting two objects there
    // what i wrote it will work if the object o is somekind of list
    public int compareTo(Object o)
    {
        boolean isEqual=false;
        for (int i = 0; i < myList.size(); i++) {
            if(!myList.get(i).compareTo((List<T>)o.get(i)))
            {
                return -1;
            }
            else return 1;
        }

    }
}
