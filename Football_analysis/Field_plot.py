import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.patches import Arc

fig=plt.figure()
ax=fig.add_subplot(1,1,1)

# ゴールライン、タッチライン
plt.plot([0,0],[0,90], color="black")
plt.plot([0,130],[90,90], color="black")
plt.plot([130,130],[90,0], color="black")
plt.plot([130,0],[0,0], color="black")

# センターライン
plt.plot([65,65],[0,90], color="black")

#左ペナルティエリア
plt.plot([16.5,16.5],[65,25],color="black")
plt.plot([0,16.5],[65,65],color="black")
plt.plot([16.5,0],[25,25],color="black")

#右ペナルティエリア
plt.plot([130,113.5],[65,65],color="black")
plt.plot([113.5,113.5],[65,25],color="black")
plt.plot([113.5,130],[25,25],color="black")

#左ゴールエリア
plt.plot([0,5.5],[54,54],color="black")
plt.plot([5.5,5.5],[54,36],color="black")
plt.plot([5.5,0.5],[36,36],color="black")

#右ゴールエリア
plt.plot([130,124.5],[54,54],color="black")
plt.plot([124.5,124.5],[54,36],color="black")
plt.plot([124.5,130],[36,36],color="black")

#センターサークル
centreCircle = plt.Circle((65,45),9.15,color="black",fill=False)
ax.add_patch(centreCircle)

#plt.show()

# 既存のコード（サッカーフィールドの描画）...

# センターサークルの追加
centreCircle = plt.Circle((65, 45), 9.15, color="black", fill=False)
ax.add_patch(centreCircle)

# データポイントと線の追加
data = pd.DataFrame(np.array([[45, 25, 60, 45]]),
                    columns=['Xstart', 'Xend', 'Ystart', 'Yend'])

plt.plot([int(data["Xstart"][0]), int(data["Xend"][0])],
         [int(data["Ystart"][0]), int(data["Yend"][0])],
         color="blue")
plt.plot(int(data["Xstart"][0]), int(data["Ystart"][0]), "o", color="green")

data = pd.DataFrame(np.array([[45, 25, 60, 45],[55, 90, 65, 30],[60, 120, 50, 70]]),
                   columns=['Xstart', 'Xend', 'Ystart', 'Yend'])

for i in range(len(data)):
    plt.plot([int(data["Xstart"][i]),int(data["Xend"][i])],
             [int(data["Ystart"][i]),int(data["Yend"][i])],
             color="blue")
    plt.plot(int(data["Xstart"][i]),int(data["Ystart"][i]),"o", color="green")
# プロットの表示
plt.show()
