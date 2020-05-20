class StockSpanner {

    // consider this as two stacks
    ArrayList<Integer> prices;
    ArrayList<Integer> count;
    int li = -1;

    public StockSpanner() {
        prices = new ArrayList<>();
        count = new ArrayList<>();
    }

    public int next(int price) {
        int c = 1;
        int i = li;
        while (i >= 0) {
            if (prices.get(i) <= price) {
                int t = count.get(i);
                c += t;
                i = i - t;
                continue;
            }
            break;
        }
        prices.add(price);
        count.add(c);
        li++;
        return c;
    }
}


// Solution with custom class Pair

// class StockSpanner {
//     ArrayList<Pair> prices;
//     public StockSpanner() {
//         prices = new ArrayList<>();
//     }

//     public int next(int price) {
//         Pair p = new Pair(price, 1);
//         int i = prices.size() - 1;
//         while( i >= 0){
//             Pair t = prices.get(i);
//             if(t.price <= price){
//                 p.count += t.count;
//                 i = i - t.count;
//                 continue;
//             }
//             break;
//         }
//         prices.add(p);
//         return p.count;
//     }
// }

// class Pair{
//     int price;
//     int count;
//     public Pair(int p, int c){
//         price = p;
//         count = c;
//     }
// }
