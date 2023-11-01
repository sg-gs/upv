import matplotlib.pyplot as plt

epoch = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
acc = [85.0, 85.8, 86.7, 87.8, 87.6, 87.5, 88.3, 87.9, 88.4, 88.1]

plt.plot(epoch, acc)
plt.xlabel('Epoch')
plt.ylabel('Accuracy (%)')
plt.show()

