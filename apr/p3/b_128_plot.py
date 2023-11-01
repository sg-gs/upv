import matplotlib.pyplot as plt

epoch = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
acc = [84.7, 86.8, 87.7, 86.8, 87.6, 88.2, 87.2, 87.6, 88.9, 88.8]

plt.plot(epoch, acc)
plt.xlabel('Epoch')
plt.ylabel('Accuracy (%)')
plt.show()

