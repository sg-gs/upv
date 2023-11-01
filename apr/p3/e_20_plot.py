import matplotlib.pyplot as plt

epoch = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
acc = [84.2, 85.4, 87.5, 86.3, 88.0, 88.2, 87.9, 88.6, 88.9, 88.2, 88.8, 88.9, 88.8, 88.7, 89.4, 
88.4, 88.8, 89.3, 89.4, 89.3]

plt.plot(epoch, acc)
plt.xlabel('Epoch')
plt.ylabel('Accuracy (%)')
plt.show()

