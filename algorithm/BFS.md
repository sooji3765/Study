## BFS : 너비우선 순회

> d[v] : s로 부터 v까지 최단 경로 : 에지의 개수
> π[v] : s부터 v까지 최단경로상에서 v 직전 노드 


- d[v] 는 `-1`로 초기화 ,-1이면 unvisited 아니면 visited;
- distance from s to s is 0
- no predecessor of s

구조화
    
    BFS (G,s) // 그래프 
    Q is empty and new ;
    d[s] = 0;
    π[s] is null;

    Enqueue(Q,s) ;

    while(Q is not empty){

        u = Dequeue(Q) ; // 노드 꺼내기
        for each v adjacent to u do
            if (v is unvisited){
                mark v as vistied;
                d[v] = d[u]+1;
                π[v] = u;
                Enquere(Q, v);
            }
        }
    }


#### 시간 복잡도

- 인접 리스트로 구현할 경우 복잡도 : O(n+m)

구조화
    
    BFS (G,s) // 그래프 
    Q is empty and new ;

    for each node u do
        d[u] = -1;
        π[s] = null'
    end

    d[s] = 0;
    π[s] is null;

    Enqueue(Q,s) ;

    while(Q is not empty){ // 최대 N 번 수행

        u = Dequeue(Q) ; // 노드 꺼내기
        for each v adjacent to u do
            if (v is unvisited){ // 인접 리스트로 구현할 경우 degree(v) 만큼 수행
               if(d[v]==-1) then 
                d[v] = d[u]+1;
                π[v] = u;
                Enquere(Q, v);
            }
        }
    }


### 최단 경로 출력하기

- 출발점에 s에서 노드 v까지 경로 출력하기

알고리즘 구조 

    PRINT-PATH(G,s,v)
    if(v=s) then
        print s;
    else if (π[v]=null) // 경로가 존재하기 x
        print "no path from s to v exists";
    else
        PRINT-PATH(G,s,π[v]);
        print v;
    end


### 그래프가 disconnected , 방향 그래프

- BFS에 의해서 모든 노드가 방문되지 않을수 있다.

- BFS를 반복하여 모든 노드 방문

알고리즘 구조

    BFS-ALL(G){
        while there exists unvisited node v
            BFS(G,v);
    }

    
