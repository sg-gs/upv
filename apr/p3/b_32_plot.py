import matplotlib.pyplot as plt

epoch = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
acc = [84.9, 85.5, 87.6, 87.0, 87.4, 87.9, 88.4, 89.0, 88.8, 88.4]

plt.plot(epoch, acc)
plt.xlabel('Epoch')
plt.ylabel('Accuracy (%)')
plt.show()

