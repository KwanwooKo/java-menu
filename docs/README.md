## 요구사항 분석

1. 매일 카테고리를 랜덤으로 설정 
    - (카테고리가 3번 이상 사용되면 안됨, 최대 2번까지 허용)
2. 각각의 코치마다 메뉴 추천 
   - (코치가 못 먹는 메뉴는 제외하고 추천해야 됨)


## Class 정보

1. Coach
   - name (String): 코치 이름
   - 지금 못먹는 음식 (Set), 이거는 코치가 못 먹는 음식 + 지금까지 먹은 음식

2. Menu
   - menu 목록 (HashMap + ArrayList)
   - 1: 일식, 2: 한식, 3: 중식, 4: 아시안, 5: 양식
   - 각각의 value는 arrayList로 저장

3. Order (하나의 요일에 대해서만 기록)
   - Coach List (ArrayList)
   - orderStatus (HashMap): 각각의 coach 에 대해 추천 받은 음식 쌍으로 저장

4. OrderHistory
   - Order List (ArrayList, type: Order, 이거 orderStatus만 집어넣어도 되긴 해): 길이는 5가 될 예정, 월~금이기 때문
   - categoryStatus(HashMap): 몇 번 사용되었는지 count, 2번 사용된 경우 다시 뽑게 하기 위함
   - 

## Method 정보

1. Coach
   - 추천 받은 음식이 생기면 지금 못 먹는 음식 set에 추가하는 메서드
   - 

2. Menu
   - category 번호를 넣을 때 해당 카테고리에 대한 arrayList를 반환하는 함수
   -  

3. Order
   - category 랜덤으로 선택하는 메서드
   - category가 3번 이상 중복되는지 확인하는 메서드
   - 음식이 코치가 못 먹는 음식인지 확인하는 메서드
   - 코치에게 음식을 추천하는 메서드 (이거는 그냥 맨 앞에거 선택, 못 먹는 음식이면 그 다음거)

4. OrderHistory
   - 결과 출력하는 함수
   - category를 랜덤으로 선택하는 함수
   - category 선택할 수 있는지 확인하는 함수 (말 그대로 2번 이상 사용되었는지 확인)