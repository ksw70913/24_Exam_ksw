import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
	Scanner sc;
	int lastId = 0;
	ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

	public App(Scanner sc) {
		this.sc = sc;

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");
		while (true) {
			System.out.print("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력하세요.");
			}

			if (cmd.equals("등록")) {
				int id = lastId + 1;

				String regDate = Time.regDate();
				System.out.print("명언 : ");
				String content = sc.nextLine().trim();
				System.out.print("작가 : ");
				String author = sc.nextLine().trim();
				System.out.printf("%s번 명언이 등록되었습니다.\n", id);

				WiseSaying wiseSaying = new WiseSaying(id, regDate, content, author);
				wiseSayings.add(wiseSaying);
				lastId++;
			} else if (cmd.equals("목록")) {
				if (wiseSayings.size() == 0) {
					System.out.println("명언이 존재하지 않습니다.");
				} else {
					System.out.println("번호	/  작가	/	명언	");
					System.out.println("=".repeat(40));
					for (int i = wiseSayings.size() - 1; i >= 0; i--) {
						WiseSaying ws = wiseSayings.get(i);
						System.out.printf("%d    /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
					}
				}
			} else if (cmd.startsWith("상세보기")) {
				String[] cmdBits = cmd.split("?", 2);
				String ActionCode = cmdBits[0];

				Map<String, String> params = new HashMap<>();
				String[] paramsBit = cmdBits[1].split("&");

				for (String paramStr : paramsBit) {
					String[] paramsStrBits = paramStr.split("=");
					String Key = paramsStrBits[0];
					String Value = paramsStrBits[1];
					params.put(Key, Value);
				}
				int id = Integer.parseInt(params.get(cmd));
				if (id <= 0) {
					System.out.println("정수를 제대로 입력하세요.");
				}
			} else if (cmd.startsWith("수정")) {
				String[] cmdBits = cmd.split("?", 2);
				String ActionCode = cmdBits[0];

				Map<String, String> params = new HashMap<>();
				String[] paramsBit = cmdBits[1].split("&");

				for (String paramStr : paramsBit) {
					String[] paramsStrBits = paramStr.split("=");
					String Key = paramsStrBits[0];
					String Value = paramsStrBits[1];
					params.put(Key, Value);
				}
				int id = Integer.parseInt(params.get(cmd));
				if (id <= 0) {
					System.out.println("정수를 제대로 입력하세요.");
				}
			} else if (cmd.startsWith("삭제")) {
				String[] cmdBits = cmd.split("?", 2);
				String ActionCode = cmdBits[0];

				Map<String, String> params = new HashMap<>();
				String[] paramsBit = cmdBits[1].split("&");

				for (String paramStr : paramsBit) {
					String[] paramsStrBits = paramStr.split("=");
					String Key = paramsStrBits[0];
					String Value = paramsStrBits[1];
					params.put(Key, Value);
				}
				int id = Integer.parseInt(params.get(cmd));
				if (id <= 0) {
					System.out.println("정수를 제대로 입력하세요.");
				}
			}

		}
	}
}
