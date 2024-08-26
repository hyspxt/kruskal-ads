package src.datastructure.unionfind;

/**
 * Union find implementation based on Quick Union with heuristic on the rank.
 * It modifies the Quick Union implementation by changing the parent of the
 * root of the tree with minimal height. This heurisitcs guarantees that
 * the trees will have a depth which is at most logarithmic in their size.
 * In this way the complexity of find is O(log n).
 *
 * @param <D> type of the data object
 */
public class QuickUnionRank<D> extends QuickUnion<D> {

	/**
	 * Creates an union find structure following the QuickUnion implementation
	 * with heuristic on the rank
	 */
	public QuickUnionRank() {
	}

	public QUnode<D> makeSet(D d) {
		QURset s = new QURset();
		QUnode<D> n = new QUnode<D>(d, s);
		return n;
	}

	public void union(QUset s, QUset t) {
		if (s == t) 
			return; /* sets are equal -> finish the recursion */
		if (((QURset) s).rank == ((QURset) t).rank) {
			super.union(s, t);
			((QURset) s).rank++;
		} else if (((QURset) s).rank > ((QURset) t).rank)
			super.union(s, t);
		else
			super.union(t, s);
	}
}
