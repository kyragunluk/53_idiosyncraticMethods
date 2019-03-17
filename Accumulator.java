/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.
 */

public class Accumulator {

    /**
      @return the concatenation of all the Strings
      in the \list that begin with \prefix,
      each followed by a space.
     */
    public static String catElementsStartingWith(List_inArraySlots list
                                                ,String prefix
                                                ) {
        String result = "";
        for( int el = 0; el < list.size(); el++)
            /* 3.  Stumbling block 0
               Java protects a programmer against applying a method
               to elements in list when some elements of the list
               might omit support for a particular operation.

               This protection is implemented by the compiler.
               The following code violates the restriction:
              */
              /*
              list.get(el).startsWith(prefix);
                  result += list.get(el);
              */
              /*
              predicted error message: cannot find symbol
              actual error message: cannot find symbol
              */


            /* 4.  Workaround 0
               A programmer should expect there to be a way to
               work around the stumbling block, because
               the JVM knows the type of an element.

               Java's instanceof operator identifies the type
               of an element to the JVM.
             */


            /* 5.  Stumbling block 1
               However, use of the operator alone is insufficient,
               because the compiler. Objects to the following
               code that adds use of the operator to the code
               from Stumbling block 0:
             */

            // [code that illustrates the use of the operator]
            /*
            if ( list.get(el) instanceof String
                && list.get(el).startsWith(prefix))
                result += list.get(el);
            */

            /*
            predicted error message: cannot find symbol
            actual error message: cannot find symbol
            */


            /* 6. Workaround 1
               Programmers use Java's cast operator to tell
               the compiler that code uses a subclass's method
               on an object, even though the reference to the
               object is stored in a super-class variable.
             */


            /* 7. Stumbling block 2
               However, use of this operator alone is insufficient,
               because the compiler objects to the following code
               that adds use of the operator to the code from
               Stumbling block 0:
             */
             /*
             String stringElement = (String)list.get(el);
             if ( stringElement.startsWith(prefix))
                  result += stringElement;
             */
             /*
             predicted error message: cannot assign refernce here
             (or something to that effect)
             actual error message: variable declaration not allowed here
             */


            /* 8. Workaround 2
               A programmer can combine use of both operators
               to apply a method to exactly those
               elements in the list that support the method.
             */

            if (list.get(el) instanceof String){
                String stringElement = (String)list.get(el);
                if (stringElement.startsWith(prefix))
                    result += stringElement + " ";
            }

        return result;
    }


    /*
      @return a list of each of the Double elements
      from the \list whose value is "finite".
     */
    public static List_inArraySlots finites(List_inArraySlots list) {
      List_inArraySlots finiteElements = new List_inArraySlots();
      for (int i = 0; i < list.size(); i++){
          if (list.get(i) instanceof Double){
              Double doubleElement = (Double)list.get(i);
              if (!doubleElement.isInfinite())
                  finiteElements.add(doubleElement);
           }
       }

    return finiteElements;
    }
}
