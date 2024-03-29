import java.util.ArrayList;

public class SetRelableConnection {

    public static void main(String[] args){
        int[] relableArr;
        int numbersOfNodes;
        int lengthConnection;
        int tmpRel;
        Node[] arrNodes;
        //TreeMap<Node, Integer> treeMapa = new TreeMap<>(Comparator.comparingInt(o -> o.numNode));
        Node DestinationElement;

        Entrance entrance = new Entrance();

        String DataInStr = entrance.SetNodesAndLengthConnection();

        String[] ArrTMP = DataInStr.split(String.valueOf(","));

        try {
            numbersOfNodes = Integer.parseInt(ArrTMP[0]);
        }
        catch (NumberFormatException e){
            System.out.println("Atention! enter the number format against.");
            return;
        }

        try {
            lengthConnection = Integer.parseInt(ArrTMP[1]);
        }
        catch (NumberFormatException e){
            System.out.println("Atention! enter the number format against.");
            return;
        }

        relableArr = entrance.SetRelablesString(numbersOfNodes);
        if (relableArr.length == 0){
            return;
        }

        int num_tmp = 0;
        for (int i = 0; i < relableArr.length; i++){
            if (relableArr[i] == 1){
                num_tmp++;
            }
        }
        arrNodes = new Node[numbersOfNodes];

        Node node = new Node(1, 1);
        Node.SetlengthConnection(lengthConnection);
        arrNodes[0] = node;
        //treeMapa.put(node, 1);

        for (int i = 2; i < numbersOfNodes; i++) {
            tmpRel = relableArr[i - 1];
            node = new Node(i, tmpRel);
            arrNodes[i - 1] = node;
            //treeMapa.put(node, i);
        }
        node = new Node(numbersOfNodes, 1);
        arrNodes[numbersOfNodes - 1] = node;
        DestinationElement = node;
        //treeMapa.put(node, numbersOfNodes);
        //--------------------------------------------------------------------------

        for (int i = 0; i < arrNodes.length; i++) {
            node = (Node) arrNodes[i];
            int mtpNumNode = node.GetNumNode();

            ArrayList<Node> arrChildNodes = Node.GetChildNodes(node, arrNodes, numbersOfNodes);
            if (arrChildNodes.contains(DestinationElement)){
                System.out.println("YES");
                return;
            }

            String str = Node.RecursionVerifyWay(arrChildNodes, arrNodes, DestinationElement, numbersOfNodes);
            if (str == "YES"){
                System.out.println(str);
                return;
            }else{
                System.out.println("NO");
                return;
            }

            //Node tmpNode = treeMapa.navigableKeySet().stream().filter(nod -> nod.GetNumNode() > 3).findFirst().get();
            //Map<Node, Integer> childNodes = treeMapa.headMap(tmpNode, true);
        }
        System.out.println("NO");
    }
}
