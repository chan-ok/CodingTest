
fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    people.sortWith(compareBy({ -it[0] }, { it[1] }))
    val list = mutableListOf<IntArray>()
    for (p in people) {
        list.add(p[1], p)
    }
    return list.toTypedArray()
}