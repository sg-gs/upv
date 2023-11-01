import matplotlib.pyplot as plt

epoch = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
acc = [84.4, 86.6, 86.3, 87.0, 87.1, 87.6, 88.3, 88.5, 88.5, 88.2]

plt.plot(epoch, acc)
plt.xlabel('Epoch')
plt.ylabel('Accuracy (%)')
plt.show()

