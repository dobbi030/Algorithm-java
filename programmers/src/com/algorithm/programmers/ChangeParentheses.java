import java.util.Scanner;
import java.util.Stack;

class ChangeParentheses {
	static public String solution(String p) {
		String answer = recursion(p);
		return answer;
	}

	static String recursion(String p) {
		int left = 0;
		int right = 0;
		int index = 0;
		String u = "";
		String v = "";
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder(p);

		if (p.length() == 0)
			return "";

		// 왼쪽 괄호와 오른쪽 괄호의 개수가 같아질 때까지 u에 추가.
		// 끝나면 index는 v의 첫번째 item을 가리킴.(p.charAt(index) = v의 첫번째 item)
		do {
			if (p.charAt(index) == '(')
				left++;
			else
				right++;
			u += p.charAt(index);
			index++;
		} while (left != right);

		v = sb.replace(0, index, "").toString();

		// 올바른 괄호 문자열인지 검사
		// 스택에 u를 앞에서부터 하나씩 넣는데 가장 최근 item이 새로 넣을 item과 짝이 맞으면 pop
		// 스택에 item이 남아있지 않으면 올바른 괄호 문자
		for (int i = 0; i < u.length(); i++) {
			if (!stack.empty() && stack.peek() == '(' && u.charAt(i) == ')') {
				stack.pop();
			} else {
				stack.push(u.charAt(i));
			}
		}

		// u가 올바른 괄호 문자가 아닌 경우에 대한 로직
		// 스택이 비지 않았다는 것은 u는 빈 문자열은 아님.
		// 주의 해야할 점: u가 올바른 괄호 문자열일 때와 아닐 때 return 값의 u, v 조합 순서가 다
		sb = new StringBuilder(u);
		if (!stack.empty()) {
			sb.deleteCharAt(0);
			sb.deleteCharAt(u.length() - 2);
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == '(') {
					sb.setCharAt(i, ')');
				} else {
					sb.setCharAt(i, '(');
				}
			}
			u = sb.toString();
			return "(" + recursion(v) + ")" + u;
		}

		System.out.println("u: " + u + ", v: " + v);
		return u + recursion(v);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String p = sc.next();
		System.out.println(solution(p));
	}
}