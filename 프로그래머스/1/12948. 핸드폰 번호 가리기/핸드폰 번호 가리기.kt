class Solution {
    fun solution(phone_number: String): String {
        val hideLength = phone_number.length - 4
        return "*".repeat(hideLength) + phone_number.substring(hideLength)
    }
}
